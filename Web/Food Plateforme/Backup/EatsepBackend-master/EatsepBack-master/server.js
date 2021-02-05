//Import dependencies
const express = require('express');
const path = require('path');
const http = require('http');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const cors = require('cors');


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

const app = express();


app.use(cors());
app.options('*', cors());
//Enable bodyParser
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:false}));

//Set API routes
//app.use('/server/api', api);
app.use('/users', users);
app.use('/dishes', dishes);
app.use('/dishdates', dishdates);
//app.use('/comments', comments);
app.use('/reservations', reservations);




/*//Enable CORS
app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
    next();
});*/

//Static path to dist
app.use(express.static(path.join(__dirname, 'angular/')));

//Catch all other routes and return to the index file
/*app.get('*', (req, res) =>{
    res.sendFile(path.join(__dirname, 'angular/src/index.html'));
});*/

//Get environment port or use 3000
const port = process.env.PORT || '3001';
app.set('port', port);

//Create HTTP server.
const server = http.createServer(app);

//Listen on port
server.listen(port, () => console.log(`API running on localhost:${port}`));
