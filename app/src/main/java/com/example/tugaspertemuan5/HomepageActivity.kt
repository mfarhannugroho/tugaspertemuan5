// HomepageActivity.kt
package com.example.tugaspertemuan5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaspertemuan5.databinding.ActivityHomepageBinding

class HomepageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding

    // Mendefinisikan kontrak untuk menerima hasil dari aktivitas lain
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data

            // Mendapatkan data yang dikirim dari MainActivity
            val username = data?.getStringExtra(MainActivity.EXTRA_USERNAME)
            val email = data?.getStringExtra(MainActivity.EXTRA_EMAIL)
            val phone = data?.getStringExtra(MainActivity.EXTRA_PHONE)

            // Menampilkan data di tampilan HomepageActivity jika tidak kosong
            if (!username.isNullOrEmpty() && !email.isNullOrEmpty() && !phone.isNullOrEmpty()) {
                binding.txtUsername.text = "$username"
                binding.txtEmail.text = "$email"
                binding.txtPhone.text = "$phone"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menginisialisasi binding untuk tata letak
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan data dari intent yang memulai aktivitas ini
        var username = intent.getStringExtra(MainActivity.EXTRA_USERNAME)
        var email = intent.getStringExtra(MainActivity.EXTRA_EMAIL)
        var phone = intent.getStringExtra(MainActivity.EXTRA_PHONE)

        // Menampilkan data di tampilan HomepageActivity
        with(binding) {
            txtUsername.text = "$username"
            txtEmail.text = "$email"
            txtPhone.text = "$phone"

            // Menangani klik tombol logout
            val btnLogout = findViewById<Button>(R.id.btn_logout)
            btnLogout.setOnClickListener {
                // Membuat intent untuk kembali ke MainActivity
                val intentToMainActivity = Intent(this@HomepageActivity, MainActivity::class.java)

                // Mengatur flag untuk membersihkan tumpukan aktivitas sebelumnya
                intentToMainActivity.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                // Memulai MainActivity
                startActivity(intentToMainActivity)
            }
        }
    }
}
