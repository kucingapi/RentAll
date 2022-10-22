package com.example.rentall.service.functions


class FunctionUserService {
    companion object{
        fun registerAllUserData(
            fullname: String,
            nik: String,
            phone: String,
            onFailure: (Throwable?) -> Unit,
            onSuccess: () -> Unit,
        ) {
            val endpoint = createEndPoint("/users-app/reg")

            val data = hashMapOf(
                "fullname" to fullname,
                "nik" to nik,
                "phone" to phone,
            )

            functions
                .getHttpsCallableFromUrl(endpoint)
                .call(data)
                .addOnSuccessListener {
                    onSuccess()
                }
                .addOnFailureListener{
                    onFailure
                }
        }
    }
}