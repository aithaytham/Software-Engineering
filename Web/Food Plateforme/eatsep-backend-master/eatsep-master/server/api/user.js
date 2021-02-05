const router = require('express').Router();
const mongoose = require('mongoose');

const Dish = mongoose.model('Dish');
const User = mongoose.model('User');
const DateD = mongoose.model('DishDate');
const Resa = mongoose.model('Reservation');
const Com = mongoose.model('Comment');
const Image = mongoose.model('Image');


var sha512 = require('js-sha512');


//Changer les ID un par un pour créer
 /*User.create({name: 'Moulin', firstname: "Jean", imagepath: "test", password: "test", email : "jm@test.fr", active : true, tel : "0123456789", address : "test test", city : "clermont city", zip : "63000"}, function(err, doc) {
 });*/

/*
Dish.create({title: 'dish test', description: "test description", images: "test", ingredients: "test", keywords : "test", categories : "test", mark : 0, nbmark : 0, user : '5ef4f5cd1807622b0f5947d4', prix : 10}, function(err, doc) {
});
*/

/*DateD.create({dish: '5ef4f6172bf1fa2b24b5c35d', date: new Date()}, function(err, doc) {
});*/
//5eb2b25c3320cb00ca812430
/*Image.create({name: 'test'}, function(err, doc) {
});*/
//5eb2b25c3320cb00ca812431




//Exemple hashage
//let testhash = sha512('Message to hash');

router.param('user', function (req, res, next, id) {
    if (!id.match(/^[0-9a-fA-F]{24}$/)) {
        return res.sendStatus(422);
    }
    User.findById(id).then((user) => {
        if (!user) {
            return res.sendStatus(404);
        }

        req.user = user;

        return next();
    })
});

router.get('/', (req, res) => {

    const email = req.query.email;

    if (email) {
        User.find({email: email})
            .populate('Dish')
            .then((user) => {
                if (!user) {
                    return res.sendStatus(404);
                }

                return res.json({
                    user: user.map((user) => {
                        return user.toDto();
                    })
                }).statusCode(200);
            });
    } else {
        User.find()
            .populate('Dish')
            .then((user) => {
                if (!user) {
                    return res.sendStatus(404);
                }

                return res.json({
                    user: user.map((user) => {
                        return user.toDto();
                    })
                }).statusCode(200);
            });
    }
});

router.post('/', (req, res) => {
    if (!req.body.name) {
        res.sendStatus(422);
    }
    console.log(req.body);
    let user = new User();
    user.name = req.body.name;
    user.firstname = req.body.firstname;
    //user.birthdate = req.body.birthdate;
    user.imagepath = req.body.imagepath;
    user.password = req.body.password;
    user.email = req.body.email;
    user.tel = req.body.tel;
    user.address = req.body.address;
    user.city = req.body.city;
    user.zip = req.body.zip;

    user.save().then(() => {

        res.json(user.toDto()).status(201);

    });
});

/*router.put('/', (req, res) => {

    if (!req.body.id) {
        res.sendStatus(422);
    }

    if (!req.body.id.match(/^[0-9a-fA-F]{24}$/)) {
        res.sendStatus(422);
    }


    User.find({email: req.body.email})
        .populate('Dish')
        .then((user) => {
            if (!user) {
                return res.sendStatus(404);
            }
            user._id = req.body.id;
            user.name = req.body.name;
            user.firstname = req.body.firstname;
            //user.birthdate = req.body.birthdate;
            user.imagepath = req.body.imagepath;
            user.password = req.body.password;
            user.email = req.body.email;
            user.tel = req.body.tel;
            user.address = req.body.address;
            user.city = req.body.city;
            user.zip = req.body.zip;


            user.save().then(() => {
                res.json(user.toDto()).statusCode(201);
            });
        });
});*/

router.put('/', (req, res) => {

    // On commence par rechercher le user souhaité
    User.findById(req.body.id, function(err, user) {
        if (err){
            res.send(err);
        }
        // Mise à jour des données du user
        user.name = req.body.name;
        user.firstname = req.body.firstname;
        //user.birthdate = req.body.birthdate;
        user.imagepath = req.body.imagepath;
        user.password = req.body.password;
        user.email = req.body.email;
        user.tel = req.body.tel;
        user.address = req.body.address;
        user.city = req.body.city;
        user.zip = req.body.zip;
        user.save(function(err){
            if(err){
                res.send(err);
            }
            res.json(user.toDto()).status(201);
        });
    });
});

router.delete('/:user', (req, res) => {
    let user = req.user;

    user.remove().then(() => {
        res.sendStatus(200);
    });
});

module.exports = router;

