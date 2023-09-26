// MainActivity.kt
package com.example.tugaspertemuan5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaspertemuan5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Mendefinisikan kunci-kunci ekstra untuk pengiriman data
    companion object {
        const val EXTRA_USERNAME = "username"
        const val EXTRA_EMAIL = "email"
        const val EXTRA_PHONE = "phone"
        const val EXTRA_PASSWORD = "password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menginisialisasi binding untuk tata letak
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menangani klik tombol register
        with(binding) {
            btnRegister.setOnClickListener {
                // Membuat intent untuk pindah ke HomepageActivity
                val intentToHome = Intent(this@MainActivity, HomepageActivity::class.java)
                // Mendapatkan nilai dari inputan pengguna
                val username = ETUsername.text.toString()
                val email = ETEMail.text.toString()
                val phone = ETPhone.text.toString()
                val password = ETPassword.text.toString()

                // Mengirim data ke HomepageActivity menggunakan intent ekstra
                intentToHome.putExtra(EXTRA_USERNAME, username)
                intentToHome.putExtra(EXTRA_EMAIL, email)
                intentToHome.putExtra(EXTRA_PHONE, phone)
                intentToHome.putExtra(EXTRA_PASSWORD, password)

                // Memulai HomepageActivity
                startActivity(intentToHome)
            }
        }
    }
}
