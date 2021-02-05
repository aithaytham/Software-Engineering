const router = require('express').Router();
const mongoose = require('mongoose');

const DishDate = mongoose.model('DishDate');
const Dish = mongoose.model('Dish');

router.param('dishDate', function (req, res, next, id) {

    if (!id.match(/^[0-9a-fA-F]{24}$/)) {
        return res.sendStatus(422);
    }

    DishDate.findById(id)
        .populate('dish')
        .then(function (todo) {
            if (!dishDate) { return res.sendStatus(404); }

            req.dishDate = dishDate;

            return next();
        });
});

router.get('/', (req, res) => {

    DishDate.find()
        .populate('dish')
        .then((dishDates) => {
            if (!dishDates) { return res.sendStatus(404); }

            return res.json({
                dishDates: dishDates.map((dishDates) => {
                    return dishDates.toDto();
                })
            }).statusCode(200);
        });
});

router.post('/', (req, res) => {
    if (!req.body.title || !req.body.description ) {
        res.sendStatus(422);
    }

    let dishDate = new DishDate();
    dishDate.dish = req.body.dish;
    dishDate.date = req.body.date;

    dishDate.save().then(() => {
        res.json(dishDate.toDto()).statusCode(201);
    })

});

router.put('/', (req, res) => {

    if (req.body.state == undefined || !req.body.id) {
        res.sendStatus(422);
    }

    if (!req.body.id.match(/^[0-9a-fA-F]{24}$/)) {
        res.sendStatus(422);
    }


    DishDate.findById(req.body.id).then((dishDate) => {
        dishDate.dish = req.body.dish;
        dishDate.date = req.body.date;

        dishDate.save().then(() => {
            res.json(dishDate.toDto()).statusCode(200);
        })
    })
});

router.delete('/:dishDate', (req, res) => {
    req.dishDate.remove().then(function () {
        return res.sendStatus(200);
    });
});

module.exports = router;




