var router = require('express').Router();

router.use('dish', require('./dish'));
router.use('user', require('./user'));
router.use('dishDate', require('./dishDate'));
//router.use('comment', require('./comment'));
router.use('reservation', require('./Reservation'));

module.exports = router;
