const functions = require("firebase-functions");
const admin = require("firebase-admin");
const db = admin.firestore();
const vehicleCollection = 'vehicle_details';
const express = require("express");
const default_image = 'https://www.pngitem.com/pimgs/m/150-1503945_transparent-user-png-default-user-image-png-png.png'
const app = express();
// const authMiddleware = require("../AuthMiddleware")

// app.use(authMiddleware);

app.post('/create', async(req, res) => {
    try {
        const vehicle = req.body;
        const data = await db.collection(vehicleCollection).add(vehicle);
        const response = {
            status: "success",
            message: "Registrasi Kendaraan berhasil",
        }
        res.status(201).send(response);

    } catch (error) {
        res.status(400).send("error di pendaftaran kendaraan");
    }

});

app.get("/", async(req, res) => {
    try {
        const snapshot = await db.collection(vehicleCollection).get();
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
            message: "berhasil mengambil semua data kendaraan",
            data: temp,
        }
        res.status(200).json(response).end;
    } catch (error) {
        res.status(500).send({
            status: "failed",
            message: "gagal dalam mengambil data kendaraan",
        }).end;
    }
});

app.get("/:id", async(req, res) => {
    try {
        const snapshot = await db.collection(vehicleCollection).doc(req.params.id).get();
        const vehicleId = snapshot.id;
        const vehicleData = snapshot.data();
        if (vehicleData.empty) {
            throw err
        }
        const response = {
            status: "success",
            message: "berhasil mengambil data kendaraan",
            data: {
                vehicleId,
                vehicleData
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
        const snapshot = await db.collection(vehicleCollection).doc(req.params.id).update({
            ...body
        });
        const response = {
            status: "success",
            message: "berhasil mengupdate data kendaraan",
        }
        res.status(200).json(response).end;
    } catch (error) {
        res.status(500).send(error);
    }
});

app.delete("/:id", async(req, res) => {
    try {
        const snapshot = await db.collection(vehicleCollection).doc(req.params.id).delete();
        const response = {
            status: "success",
            message: "berhasil menghapus data kendaraan",
        }
        res.status(200).json(response).end;
    } catch (error) {
        res.status(500).send(error);
    }
});



exports.app = functions.https.onRequest(app);