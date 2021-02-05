const mongoose = require('mongoose');
const Dish = mongoose.model('Dish');
const User = mongoose.model('User');

let ReservationSchema = new mongoose.Schema({
    dishDate: {type: mongoose.Schema.Types.ObjectId, ref: 'DishDate'},
    user: {type: mongoose.Schema.Types.ObjectId, ref: 'User'},
    isAccepted: {type: Boolean},
    comment: {type: String}
}, {timestamps: true});

ReservationSchema.methods.toDto = function () {

    return {
        id: this._id,
        dishDate: this.dishDate,
        user: this.user,
        isAccepted: this.isAccepted,
        comment: this.comment
    }
};

mongoose.model('Reservation', ReservationSchema);
