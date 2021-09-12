package com.beratyesbek.e_commerce_android.activities

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.beratyesbek.e_commerce_android.R
import com.beratyesbek.e_commerce_android.databinding.ActivityPaymentBinding
import java.util.*
import java.text.DateFormat;
import java.util.Calendar;
import com.beratyesbek.e_commerce_android.fragments.DatePickerFragment



class PaymentActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener  {

    private lateinit var dataBinding: ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityPaymentBinding.inflate(layoutInflater)
        val view = dataBinding.root
        setContentView(view)

        dataBinding.btnChooseDate.setOnClickListener {
            val datePicker: DialogFragment = DatePickerFragment()
            datePicker.show(supportFragmentManager, "date picker")
        }

    }

    fun payment(view :View){
        System.out.println(dataBinding.payment?.cardHolderName)
        System.out.println(dataBinding.payment?.cardNumber)
        System.out.println(dataBinding.payment?.cvv)
        System.out.println(dataBinding.payment?.email)

    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val c: Calendar = Calendar.getInstance()
        c.set(Calendar.YEAR, year)
        c.set(Calendar.MONTH, month)
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        val currentDateString: String =
            DateFormat.getDateInstance(DateFormat.FULL).format(c.time)
        System.out.println(currentDateString)
    }
}