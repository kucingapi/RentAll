const functions = require("firebase-functions");
const admin = require("firebase-admin");
const db = admin.firestore();
const dbCollection = 'orders';
const express = require("express");
const app = express();
const validator = require("../AuthMiddleware")

app.use(validator);

app.post('/create', async(req, res) => {
    try {
        const order = req.body;
        const data = await db.collection(dbCollection).add(order);
        const response = {
            status: "success",
            message: "pembuatan pesanan berhasil",
        }
        res.status(201).send(response);
    } catch (error) {
        res.status(400).send("error di pembuatan pesanan");
    }
});

app.get("/", async(req, res) => {
    try {
        const snapshot = await db.collection(dbCollection).get();
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
            message: "berhasil mengambil semua data",
            data: temp,
        }
        res.status(200).json(response).end;
    } catch (error) {
        res.status(404).send({
            status: "failed",
            message: "gagal dalam mengambil data",
        }).end;
    }
});

app.get("/:id", async(req, res) => {
    try {
        const snapshot = await db.collection(dbCollection).doc(req.params.id).get();
        const id = snapshot.id;
        const data = snapshot.data();
        if (data.empty) {
            throw err
        }
        const response = {
            status: "success",
            message: "berhasil mengambil data",
            data: {
                id,
                data
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
        const snapshot = await db.collection(dbCollection).doc(req.params.id).update({
            ...body
        });
        const response = {
            status: "success",
            message: "berhasil mengupdate data",
        }
        res.status(200).json(response).end;
    } catch (error) {
        res.status(500).send(error);
    }
});

app.delete("/:id", async(req, res) => {
    try {
        const snapshot = await db.collection(dbCollection).doc(req.params.id).delete();
        const response = {
            status: "success",
            message: "berhasil menghapus data",
        }
        res.status(200).json(response).end;
    } catch (error) {
        res.status(500).send(error);
    }
});


exports.app = functions.region('asia-southeast2').https.onRequest(app);