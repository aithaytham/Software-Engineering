const router = require('express').Router();
const mongoose = require('mongoose');

const Dish = mongoose.model('Dish');
const User = mongoose.model('User');

router.param('dish', function (req, res, next, id) {

    if (!id.match(/^[0-9a-fA-F]{24}$/)) {
        return res.sendStatus(422);
    }

    Dish.findById(id)
        .populate('user')
        .populate('images')
        .then(function (todo) {
            if (!dish) { return res.sendStatus(404); }

            req.dish = dish;

            return next();
        });
});

router.get('/', (req, res) => {

    Dish.find()
        .populate('user')
        .populate('images')
        .then((dishs) => {
            if (!dishs) { return res.sendStatus(404); }

            return res.json({
                dishs: dishs.map((dish) => {
                    return dish.toDto();
                })
            }).statusCode(200);
        });
});

router.post('/', (req, res) => {
    if (!req.body.title || !req.body.description ) {
        res.sendStatus(422);
    }

    let dish = new Dish();
    dish.title = req.body.title;
    dish.description = req.body.description;
    dish.images = req.body.images;
    dish.ingredients = req.body.ingredients;
    dish.keywords = req.body.keywords;
    dish.categories = req.body.categories;
    dish.mark = 0;
    dish.nbmark = 0;

    dish.save().then(() => {
        res.json(dish.toDto()).statusCode(201);
    })

});

router.put('/', (req, res) => {

    if (req.body.state == undefined || !req.body.id) {
        res.sendStatus(422);
    }

    if (!req.body.id.match(/^[0-9a-fA-F]{24}$/)) {
        res.sendStatus(422);
    }


    Dish.findById(req.body.id).then((dish) => {
        dish.title = req.body.title;
        dish.description = req.body.description;
        dish.images = req.body.images;
        dish.ingredients = req.body.ingredients;
        dish.keywords = req.body.keywords;
        dish.categories = req.body.categories;

        dish.save().then(() => {
            res.json(dish.toDto()).statusCode(200);
        })
    })
});

router.delete('/:dish', (req, res) => {
    req.dish.remove().then(function () {
        return res.sendStatus(200);
    });
});

module.exports = router;




