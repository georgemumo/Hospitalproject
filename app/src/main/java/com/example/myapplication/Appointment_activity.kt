package com.example.myapplication
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.app.DatePickerDialog
import android.app.TimePickerDialog
//import android.os.Bundle
//import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class Appointment_activity : AppCompatActivity() {
    private lateinit var doctorSpinner: Spinner
    private lateinit var dateButton: Button
    private lateinit var timeButton: Button
    private lateinit var sheduleButton: Button

    private var selectedDate:String=""
    private var selectedTime:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)

        doctorSpinner = findViewById(R.id.doctorSpinner)
        dateButton = findViewById(R.id.dateButton)
        timeButton = findViewById(R.id.timeButton)
        sheduleButton = findViewById(R.id.sheduleButton)

        dateButton.setOnClickListener{
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(this, { _, year, monthOfYear, dayOfMonth ->
                selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                dateButton.text = selectedDate
            }, year, month, day)
                datePickerDialog.show()

        }
        timeButton.setOnClickListener{
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val timePickerDialog = TimePickerDialog(this, { _, hourOfDay, minute ->
                selectedTime = "$hourOfDay:$minute"
            }, hour, minute, true)
            timePickerDialog.show()

        }
        sheduleButton.setOnClickListener{
            val doctor = doctorSpinner.selectedItem.toString()
            if(selectedDate.isNotEmpty() && selectedTime.isNotEmpty()){
                Toast.makeText(this, "Appointment scheduled for $selectedDate at $selectedTime with $doctor", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "Please select a date and time", Toast.LENGTH_SHORT).show()
            }
        }

    }

}

