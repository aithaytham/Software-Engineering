import express from 'express'
import bodyParser from 'body-parser'

const app = express()
const path = require('path');
app.use(express.static("views"));
const mongoose = require('mongoose');
const moment = require('moment');
const multer = require('multer');
const fs = require('fs');

//Connect to mongoDB server
mongoose.connect('mongodb://localhost/eatsep');
mongoose.set('debug', true);

//Require the models
require('./server/models/User'); //HERE
require('./server/models/Dish'); //HERE
require('./server/models/DishDate'); //HERE
require('./server/models/Comment'); //HERE
require('./server/models/Image'); //HERE
require('./server/models/Reservation'); //HERE

//Get our API routes
//const api = require('./server/api/');
let users = require('./server/api/user');
let dishes = require('./server/api/dish');
let dishdates = require('./server/api/dishDate');
//let comments = require('./server/api/comment');
let reservations = require('./server/api/reservation');


app.use(bodyParser.json())
app.use(bodyParser.urlencoded({extended: true}));
app.use('/uploads', express.static('uploads'));

//Set API routes
//app.use('/server/api', api);
app.use('/users', users);
app.use('/dishes', dishes);
app.use('/dishdates', dishdates);
//app.use('/comments', comments);
app.use('/reservations', reservations);


// SET STORAGE
var storage = multer.diskStorage({
    destination: function (req, file, cb) {
        cb(null, 'uploads/images/')
    },
    filename: function (req, file, cb) {
        cb(null, file.fieldname + '-' + Date.now() + '.png')
    }
})

var limits = { fileSize: 5 * 1024 * 1024, fieldSize: 5 * 1024 * 1024}

var upload = multer({storage: storage, limits: limits})
app.use(function (_req, res, next) {
    res.header('Access-Control-Allow-Origin', '*')
    res.header('Access-Control-Allow-Methods', 'GET, PUT, POST, DELETE')
    res.header(
        'Access-Control-Allow-Headers',
        'Origin, X-Requested-With, Content-Type, Accept'
    )
    next()
})

export default app
