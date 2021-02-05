const mongoose = require('mongoose');
const Dish = mongoose.model('Dish');
const User = mongoose.model('User');

let CommentSchema = new mongoose.Schema({
    dish: {type: mongoose.Schema.Types.ObjectId, ref: 'Dish'},
    user: {type: mongoose.Schema.Types.ObjectId, ref: 'User'},
    content: {type: String}
}, {timestamps: true});

CommentSchema.methods.toDto = function () {

    return {
        dish: this.dish.toDto(),
        user: this.user.toDto(),
        content: this.content
    }
};

mongoose.model('Comment', CommentSchema);
