package com.example.rentall.service.functions

import android.util.Log

class FunctionVehicleService {
    companion object{
        fun getAllVehicle(
            onFailure: (Throwable?) -> Unit,
            onSuccess: () -> Unit,
        ) {
            val endpoint = createEndPoint("/vehicle-app/")


            functions
                .getHttpsCallableFromUrl(endpoint)
                .call()
                .addOnSuccessListener {
                    Log.d("vehicle", it.data.toString())
                    onSuccess()
                }
                .addOnFailureListener{
                    Log.d("vehicle", it.message.toString())
                    onFailure(it)
                }
        }
    }
}