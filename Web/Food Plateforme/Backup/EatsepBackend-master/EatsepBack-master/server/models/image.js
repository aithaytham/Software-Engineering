const mongoose = require('mongoose');

let ImageSchema = new mongoose.Schema({
    name: {type: String, required: [true, "can't be blank"], index: true}
}, {timestamps: true});

ImageSchema.methods.toDto = function () {

    return {
        id: this._id,
        name: this.name
    }
};

mongoose.model('Image', ImageSchema);
