# IfestUnpad

<div align="center">
  <img src="https://drive.google.com/uc?id=1mdHcf6SkQRkJ26kToINSBPYzMZM03rnl" alt="Logo" width="80" height="80">
  <h3 align="center">RentAll</h3>
</div>



## Team 

### BCC 50% Jomblo

1. Adin Ilham Fahrezi
2. Novel Bafagih
3. Vania Sahda Annabelle
4. Muhammad Rafly Alfayed 

## Instalation Guide

1. download file .zip
2. modify `app/src/google service.json`
```
{
  "project_info": {
    "project_number": "1016889449917",
    "project_id": "reantalin",
    "storage_bucket": "reantalin.appspot.com"
  },
  "client": [
    {
      "client_info": {
        "mobilesdk_app_id": "1:1016889449917:android:44ab93c85ba2c5457d46d4",
        "android_client_info": {
          "package_name": "com.example.rentall"
        }
      },
      "oauth_client": [
        {
          "client_id": "1016889449917-6ns8tnuspao7voo2ro7r8l69l6o2j2ke.apps.googleusercontent.com",
          "client_type": 3
        }
      ],
      "api_key": [
        {
          "current_key": "AIzaSyAxfdZ2T6nWKmjozaa75DFgOX7GxzT0xZg"
        }
      ],
      "services": {
        "appinvite_service": {
          "other_platform_oauth_client": [
            {
              "client_id": "1016889449917-6ns8tnuspao7voo2ro7r8l69l6o2j2ke.apps.googleusercontent.com",
              "client_type": 3
            }
          ]
        }
      }
    }
  ],
  "configuration_version": "1"
}
```
3. add `GMP_KEY` in `local.properties`
```
GMP_KEY=AIzaSyCWqtWHjoLVxDMhJ7sBOn0NK8M0_dHvIcg
```
