const router = require('express').Router();
const mongoose = require('mongoose');

const Dish = mongoose.model('Dish');
const User = mongoose.model('User');
const DateD = mongoose.model('DishDate');
const Resa = mongoose.model('Reservation');
const Com = mongoose.model('Comment');
const Image = mongoose.model('Image');


var sha512 = require('js-sha512');

/*
//Changer les ID un par un pour créer
User.create({name: 'Moulin', firstname: "Jean", imagepath: "test", password: "test", email : "jm@test.fr", active : true, tel : "0123456789", address : "test test", city : "clermont city", zip : "63000"}, function(err, doc) {
});*/
/*
Dish.create({title: 'dish test', description: "test description", imagepath: "test", ingredients: "test", keywords : "test", categories : "test", mark : 0, nbmark : 0, user : '5cebd9e21be62454060ca1d0', prix : 10}, function(err, doc) {
});

DateD.create({dish: '5cffbaee4cd4870b6e7c58d8', date: new Date()}, function(err, doc) {
});
Image.create({name: 'test'}, function(err, doc) {
});
 */


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

    if(email){
        User.find({ email: email })
            .populate('Dish')
            .then((user) => {
                if (!user) { return res.sendStatus(404); }

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
                if (!user) { return res.sendStatus(404); }

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
    user.email = req.body.email;
    user.password = req.body.password;

    user.save().then(() => {

            res.json(user.toDto()).statusCode(201);

    });
});

router.put('/', (req, res) => {

    if (req.body.state == undefined || !req.body.id) {
        res.sendStatus(422);
    }

    if (!req.body.id.match(/^[0-9a-fA-F]{24}$/)) {
        res.sendStatus(422);
    }


    User.findById(req.body.id).then((user) => {
        user.name = req.body.name;
        user.firstname = req.body.firstname;
        user.birthDate = req.body.birthDate;
        user.imagepath = req.body.imagepath;
        user.password = req.body.password;
        user.email = req.body.email;
        user.phone = req.body.phone;

        user.save().then(() => {
            res.json(user.toDto()).statusCode(200);
        })
    })
});


router.delete('/:user', (req, res) => {
    let user = req.user;

    user.remove().then(() => {
        res.sendStatus(200);
    });
});

module.exports = router;

