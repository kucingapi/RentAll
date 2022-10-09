const functions = require("firebase-functions");
const admin = require("firebase-admin");
const db = admin.firestore();
const userCollection = 'user_details';
const express = require("express");
const default_image = 'https://www.pngitem.com/pimgs/m/150-1503945_transparent-user-png-default-user-image-png-png.png'
const app = express();
// const authMiddleware = require("../AuthMiddleware")

// app.use(authMiddleware);

app.post('/reg', async(req, res) => {
    try {
        const user = {
            ...req.body,
            image: default_image,
        }
        const data = await db.collection(userCollection).add(user);
        const response = {
            status: "success",
            message: "Registrasi berhasil",
        }
        res.status(201).send(response);

    } catch (error) {
        res.status(400).send("error di pembuataan akun");
    }

});

app.get("/", async(req, res) => {
    try {
        const snapshot = await db.collection(userCollection).get();
        let temp = [];
        snapshot.forEach(doc => {
            let id = doc.id;
            let data = doc.data();
            temp.push({
                id,
                ...data
            })
        });
        const response = {
            status: "success",
            message: "berhasil mengambil data user",
            data: temp,
        }
        res.status(200).json(response).end;
    } catch (error) {
        res.status(500).send({
            status: "failed",
            message: "gagal dalam mengambil data",
            error: error
        }).end;
    }
});

app.get("/:id", async(req, res) => {
    try {
        const snapshot = await db.collection(userCollection).doc(req.params.id).get();
        const userId = snapshot.id;
        const userData = snapshot.data();
        if (userData.empty) {
            throw err
        }
        const response = {
            status: "success",
            message: "berhasil mengambil data user",
            data: {
                userId,
                userData
            }
        }
        res.status(200).json(response).end
    } catch (err) {
        res.status(404).send({
            status: "failed",
            code: "404",
            message: "data not found"
        }).end
    }
});

app.put("/:id", async(req, res) => {
    try {
        const body = req.body;
        const snapshot = await db.collection(userCollection).doc(req.params.id).update({
            ...body
        });
        const response = {
            status: "success",
            message: "berhasil mengupdate data user",
        }
        res.status(200).json(response).end;
    } catch (error) {
        res.status(500).send(error);
    }
});

app.delete("/:id", async(req, res) => {
    try {
        const snapshot = await db.collection(userCollection).doc(req.params.id).delete();
        const response = {
            status: "success",
            message: "berhasil menghapus data user",
        }
        res.status(200).json(response).end;
    } catch (error) {
        res.status(500).send(error);
    }
});



exports.app = functions.https.onRequest(app);