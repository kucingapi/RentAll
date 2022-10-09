const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors");
const admin = require("firebase-admin");

const main = express();
admin.initializeApp();

main.use(bodyParser.json())
main.use(bodyParser.urlencoded({ extended: false }))
main.use(cors({ origin: true }))


exports.users = require("./controllers/user.controllers");
exports.vehicle = require("./controllers/vehicle.controller");
exports.category = require("./controllers/category.controller");
exports.order = require("./controllers/order.controller");