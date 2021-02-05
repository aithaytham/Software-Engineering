const mongoose = require('mongoose');
const User = mongoose.model('User');

let DishSchema = new mongoose.Schema({
    title: {type: String, required: [true, "can't be blank"], index: true},
    description: {type: String, maxlength: 500},
    images: [{type: mongoose.Schema.Types.ObjectId, ref: 'Image'}],
    ingredients: {type: String, maxlength: 500},
    keywords: [{type: String, maxlength: 255}],
    categories: [{type: String, maxlength: 255}],
    mark: {type: Number},
    nbmark: {type: Number},
    user: {type: mongoose.Schema.Types.ObjectId, ref: 'User'},
    prix: {type: Number},
}, {timestamps: true});

DishSchema.methods.toDto = function () {

    return {
        id: this._id,
        title: this.title,
        description: this.description,
        images: this.images.map((image) => {
            return image.toDto();
        }),
        ingredients: this.ingredients,
        keywords: this.keywords,
        categories: this.categories,
        mark: this.mark,
        user: this.user,
        prix: this.prix
    }
};

mongoose.model('Dish', DishSchema);

//prix
