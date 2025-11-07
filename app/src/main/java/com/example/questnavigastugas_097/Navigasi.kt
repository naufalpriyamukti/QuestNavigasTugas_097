package com.example.questnavigastugas_097

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Navigasi {
    HomeDepan,
    Formulir,
    TampilData
}
@Composable
fun Prak6App(
    navController: NavHostController = rememberNavController()
)
{
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = com.example.prak6.Navigasi.HomeDepan.name,
            modifier = Modifier.padding(innerPadding)
        ){
            // Halaman Selamat Datang
            composable(com.example.prak6.Navigasi.HomeDepan.name) {
                HomeDepan(
                    onSubmitClick = {
                        navController.navigate(com.example.prak6.Navigasi.Formulir.name)
                    }
                )
            }

            // Halaman Formulir Pendaftaran
            composable(com.example.prak6.Navigasi.Formulir.name) {
                Formulir(
                    onSubmitClick = { nama, jenis, status, alamat ->
                        navController.navigate(
                            "${com.example.prak6.Navigasi.TampilData.name}/$nama/$jenis/$status/$alamat"
                        )
                    }
                )
            }

        }
    }

}