const mongoose = require('mongoose');
const Dish = mongoose.model('Dish');

let DishDateSchema = new mongoose.Schema({
    dish: {type: mongoose.Schema.Types.ObjectId, ref: 'Dish'},
    date: {type: Date}
}, {timestamps: true});

DishDateSchema.methods.toDto = function () {

    return {
        id: this._id,
        dish: this.dish.toDto(),
        date: this.date
    }
};

mongoose.model('DishDate', DishDateSchema);
