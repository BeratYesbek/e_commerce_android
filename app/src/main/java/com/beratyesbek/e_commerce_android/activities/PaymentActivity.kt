package com.beratyesbek.e_commerce_android.activities

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.activity.viewModels
import androidx.fragment.app.DialogFragment
import com.beratyesbek.e_commerce_android.R
import com.beratyesbek.e_commerce_android.databinding.ActivityPaymentBinding
import java.util.*
import java.text.DateFormat;
import java.util.Calendar;
import com.beratyesbek.e_commerce_android.fragments.DatePickerFragment
import com.beratyesbek.e_commerce_android.models.Payment
import com.beratyesbek.e_commerce_android.models.dtos.CartSummaryDto
import com.beratyesbek.e_commerce_android.mvvm.PaymentViewModel
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import kotlin.collections.ArrayList


class PaymentActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener  {

    private val cartSummaryList = ArrayList<CartSummaryDto>()
    private lateinit var dataBinding: ActivityPaymentBinding
    private val viewModel :PaymentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityPaymentBinding.inflate(layoutInflater)
        val view = dataBinding.root
        setContentView(view)

        cartSummaryList.addAll(intent.getParcelableArrayListExtra<CartSummaryDto>("cartSummaryList") as ArrayList<CartSummaryDto>)


    }

    fun payment(view :View){
        val cardHolderName = dataBinding.textviewPaymentActivityCardHolderName.text.toString()
        val cardNumber = dataBinding.textviewPaymentActivityCardNumber.text.toString()
        val cvv = dataBinding.textviewPaymentActivityCvv.text.toString().toInt()
        val expiryDate = dataBinding.textviewPaymentActivityExpiryDate.text.toString()
        val address = dataBinding.textviewPaymentActivityAddress.text.toString()
        val phone = dataBinding.textviewPaymentActivityPhoneNumber.text.toString()
        val email = dataBinding.textviewPaymentActivityEmail.text.toString()
        val current = Calendar.getInstance().time

        val paymentList = ArrayList<Payment>()

        if (cartSummaryList != null){
            for (item in cartSummaryList){
                val payment = Payment(null,cardNumber
                    ,cardHolderName,expiryDate,cvv,1,address,phone,item.productId,item.id,item.product.productPrice!!,current,email
                )
                paymentList.add(payment)
            }
            viewModel.add(paymentList)

        }

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