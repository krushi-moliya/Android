package com.example.mydatabase

import android.content.ContentValues
import android.content.DialogInterface
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var btn_insert : Button
    lateinit var btn_update : Button
    lateinit var btn_delete : Button
    lateinit var btn_clear : Button
    lateinit var btn_next : Button
    lateinit var btn_prev : Button
    lateinit var btn_first : Button
    lateinit var btn_last : Button
    lateinit var ed_name : EditText
    lateinit var ed_sem : EditText
    lateinit var btn_showall : Button
    lateinit var listview : ListView
    lateinit var searchview : SearchView
    lateinit var rs : Cursor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_insert = findViewById(R.id.btn_insert)
        btn_update  = findViewById(R.id.btn_update)
        btn_delete = findViewById(R.id.btn_delete)
        btn_clear = findViewById(R.id.btn_clear)
        btn_next = findViewById(R.id.btn_next)
        btn_prev = findViewById(R.id.btn_prev)
        btn_first = findViewById(R.id.btn_first)
        btn_last = findViewById(R.id.btn_last)
        ed_name = findViewById(R.id.ed_name)
        ed_sem = findViewById(R.id.ed_sem)
        btn_showall = findViewById(R.id.btn_showall)
        listview = findViewById(R.id.listview)
        searchview = findViewById(R.id.searchview)

        var helper = MyDBHelper(applicationContext)
        var db = helper.writableDatabase
        //Toast.makeText(applicationContext,"Db  create and Table created",Toast.LENGTH_SHORT).show()

        rs = db.rawQuery("SELECT SID _id, SNAME, SEM FROM STUDENT",null)
        if(rs.moveToFirst()){
            ed_name.setText(rs.getString(1))
            ed_sem.setText(rs.getString(2))
        }

        //INSERT RECORDS
        btn_insert.setOnClickListener{
            var cv = ContentValues()
            cv.put("SNAME",ed_name.text.toString())
            cv.put("SEM",ed_sem.text.toString())
            db.insert("STUDENT",null,cv)
            rs = db.rawQuery("SELECT SID _id, SNAME, SEM FROM STUDENT",null)
            showMessage("Record Inserted Successfullt!! ")
            clear()
        }

        //UPDATE RECORDS
        btn_update.setOnClickListener {
            var cv = ContentValues()
            cv.put("SNAME",ed_name.text.toString())
            cv.put("SEM",ed_sem.text.toString())
            db.update("STUDENT",cv,"SID = ?", arrayOf(rs.getString(0)))
            rs = db.rawQuery("SELECT SID _id, SNAME, SEM FROM STUDENT",null)
            showMessage("Record Updated Successfully!!!")
            clear()
        }

        //DELETE
        btn_delete.setOnClickListener {
            db.delete("STUDENT","SID =?", arrayOf(rs.getString(0)))
            rs = db.rawQuery("SELECT SID _id, SNAME, SEM FROM STUDENT",null)
            showMessage("Record Deleted Successfully!!!")
            clear()
        }

        //CLEAR
        btn_clear.setOnClickListener {
            clear()
        }

        //NEXT
        btn_next.setOnClickListener {
            if(rs.moveToNext()){
                ed_name.setText(rs.getString(1))
                ed_sem.setText(rs.getString(2))
            }else if(rs.moveToFirst()){
                ed_name.setText(rs.getString(1))
                ed_sem.setText(rs.getString(2))
            }else{
                Toast.makeText(applicationContext,"Data Not Found!!!",Toast.LENGTH_SHORT).show()
            }
        }

        //PREVIOUS
        btn_prev.setOnClickListener {
            if(rs.moveToPrevious()){
                ed_name.setText(rs.getString(1))
                ed_sem.setText(rs.getString(2))
            }else if(rs.moveToLast()){
                ed_name.setText(rs.getString(1))
                ed_sem.setText(rs.getString(2))
            }else{
                Toast.makeText(applicationContext,"Data Not Found!!!",Toast.LENGTH_SHORT).show()
            }
        }

        //FIRST RECORD
        btn_first.setOnClickListener {
            if(rs.moveToFirst()){
                ed_name.setText(rs.getString(1))
                ed_sem.setText(rs.getString(2))
            }else{
                Toast.makeText(applicationContext,"Data Not Found!!!",Toast.LENGTH_SHORT).show()
            }
        }

        //LAST RECORD
        btn_last.setOnClickListener {
            if(rs.moveToLast()){
                ed_name.setText(rs.getString(1))
                ed_sem.setText(rs.getString(2))
            }else{
                Toast.makeText(applicationContext,"Data Not Found!!!",Toast.LENGTH_SHORT).show()
            }
        }

        //SHOW ALL RECORDS
        btn_showall.setOnClickListener{
            var adapter = SimpleCursorAdapter(applicationContext,R.layout.my_layout,rs,
                 arrayOf("SNAME","SEM"),
                intArrayOf(R.id.textView,R.id.textView2))
            listview.adapter = adapter

            //SEARCH VIEW
            searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    rs = db.rawQuery("SELECT SID _id, SNAME, SEM FROM STUDENT WHERE SNAME LIKE '%${p0}%' OR SEM LIKE '%${p0}%'",null)
                    adapter.changeCursor(rs)
                    return false
                }

            })
        }


    }

    private fun clear() {
        ed_name.setText("")
        ed_sem.setText("")
        ed_name.requestFocus()
    }

    private fun showMessage(s: String){
        AlertDialog.Builder(this)
            .setTitle("Success!!")
            .setMessage(s)
            .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->

            }).show()
    }


}