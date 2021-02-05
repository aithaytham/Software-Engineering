//USER MODEL

const mongoose = require('mongoose');

let UserSchema = new mongoose.Schema({
    name: { type: String, maxlength: 200 },
    firstname: { type: String, maxlength: 200 },
    imagepath: { type: String, maxlength: 200 },
    password: { type: String, maxlength: 255 },
    email: { type: String, maxlength: 255 },
    active: { type: Boolean, default: true },
    tel: { type: String, maxlength: 200 },
    address: { type: String, maxlength: 200 },
    zip: { type: String, maxlength: 200 },
    city: { type: String, maxlength: 200 },
}, { timestamps: true });


UserSchema.methods.toDto = function () {

    return {
        id: this._id,
        name: this.name,
        firstname: this.firstname,
        imagepath: this.imagepath,
        password: this.password,
        email: this.email,
        tel: this.tel,
        address: this.address,
        zip: this.zip,
        city: this.city
    }
};

mongoose.model('User', UserSchema);

