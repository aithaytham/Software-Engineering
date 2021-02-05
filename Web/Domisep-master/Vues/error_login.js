var formModal = $('.cd-user-modal'),
    formLogin = formModal.find('#cd-login'),
    formSignup = formModal.find('#cd-signup'),
    formForgotPassword = formModal.find('#cd-reset-password'),
    formModalTab = $('.cd-switcher'),
    tabLogin = formModalTab.children('li').eq(0).children('a'),
    tabSignup = formModalTab.children('li').eq(1).children('a'),
    forgotPasswordLink = formLogin.find('.cd-form-bottom-message a'),
    backToLoginLink = formForgotPassword.find('.cd-form-bottom-message a'),
    mainNav = $('.main-nav');

//open modal
mainNav.on('click', function(event){
    $(event.target).is(mainNav) && mainNav.children('ul').toggleClass('is-visible');

});

//open sign-up form
mainNav.on('click', '.cd-signup', signup_selected);
//open login-form form
mainNav.on('click', '.cd-signin', login_selected);


//close modal
formModal.on('click', function(event){
    if( $(event.target).is(formModal) || $(event.target).is('.cd-close-form') ) {
        formModal.removeClass('is-visible');
    }
});

function login_selected(){
    mainNav.children('ul').removeClass('is-visible');
    formModal.addClass('is-visible');
    formLogin.addClass('is-selected');
    formSignup.removeClass('is-selected');
    formForgotPassword.removeClass('is-selected');
    tabLogin.addClass('selected');
    tabSignup.removeClass('selected');
}

function signup_selected(){
    mainNav.children('ul').removeClass('is-visible');
    formModal.addClass('is-visible');
    formLogin.removeClass('is-selected');
    formSignup.addClass('is-selected');
    formForgotPassword.removeClass('is-selected');
    tabLogin.removeClass('selected');
    tabSignup.addClass('selected');
}

function forgot_password_selected(){
    formLogin.removeClass('is-selected');
    formSignup.removeClass('is-selected');
    formForgotPassword.addClass('is-selected');
}

mainNav.click('.cd-signin', login_selected);

var formModal = $('.cd-user-modal'),
    formLogin = formModal.find('#cd-login');


formLogin.find('input[type="email"]').toggleClass('has-error').next('span').toggleClass('is-visible');


