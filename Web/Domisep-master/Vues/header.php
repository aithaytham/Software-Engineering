<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="Vues/modal/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="Vues/modal/css/style.css"> <!-- Gem style -->
    <?= Domisep\Vues\VueHtmlUtils::cssHTML5(\Domisep\Config\Config::getStyleSheetsURL()['header']); ?>

</head>

<body onload="init()">
<ul class="list">
    <li class="link" style="width: 3%" ><a href="?action=index"><img src="<?= Domisep\Config\Config::getResources()['logo'] ?>"style=" width: 90%; border-color: white; border-radius: 10px; border: solid;"></a></li>
    <li class="link" ><a href="?action=index">Home</a></li>
    <li class="link" ><a id="index" href="?action=contact">Contact</a></li>

<nav id="mainnav" class="main-nav">
    <ul id="list-nav">
        <!-- inser more links here -->
        <li class="link"><a id="signin" class="cd-signin" href="#0">Sign in</a></li>
        <li class="link"><a id="signup" class="cd-signup" href="#0">Sign up</a></li>
    </ul>
</nav>
</ul>

<div class="cd-user-modal"> <!-- this is the entire modal form, including the background -->
    <div class="cd-user-modal-container"> <!-- this is the container wrapper -->
        <ul class="cd-switcher">
            <li><a href="#0">Sign in</a></li>
            <li><a href="#0">New account</a></li>
        </ul>

        <div id="cd-login"> <!-- log in form -->
            <form method="post" class="cd-form" action="?action=validateLogin">
                <p class="fieldset">
                    <label class="image-replace cd-email" for="signin-email">E-mail</label>
                    <input class="full-width has-padding has-border" id="signin-email" name="email" type="email" placeholder="E-mail">
                    <span class="cd-error-message">Invalid email or password</span>
                </p>

                <p class="fieldset">
                    <label class="image-replace cd-password" for="signin-password">Password</label>
                    <input class="full-width has-padding has-border" id="signin-password" name="password" type="text"  placeholder="Password">
                    <a href="#0" class="hide-password">Hide</a>
                </p>

                <p class="fieldset">
                    <input type="checkbox" id="remember-me" checked>
                    <label for="remember-me" style="color: black">Remember me</label>
                </p>

                <p class="fieldset">
                    <input class="full-width" type="submit" id="submit" value="Login">
                </p>
            </form>

            <p class="cd-form-bottom-message"><a href="#0">Forgot your password?</a></p>
            <!-- <a href="#0" class="cd-close-form">Close</a> -->
        </div> <!-- cd-login -->

        <div id="cd-signup"> <!-- sign up form -->
            <form method="post" class="cd-form" action="?action=validateRegister">
                <p class="fieldset">
                    <label class="image-replace cd-username" for="signup-username">Username</label>
                    <input class="full-width has-padding has-border" id="signup-username" type="text" name="nom" placeholder="Last name" required>
                    <span class="cd-error-message">Error message here!</span>
                </p>

                <p class="fieldset">
                    <label class="image-replace cd-username" for="signup-username">Username</label>
                    <input class="full-width has-padding has-border" id="signup-username" type="text" name="prenom" placeholder="First name" required>
                    <span class="cd-error-message">Error message here!</span>
                </p>

                <p class="fieldset">
                    <label class="image-replace cd-email" for="signup-email">E-mail</label>
                    <input class="full-width has-padding has-border" id="signup-email" type="email" name="email" placeholder="E-mail" required>
                    <span class="cd-error-message">Invalid or already used email</span>
                </p>

                <p class="fieldset">
                    <label class="image-replace cd-password" for="signup-password">Password</label>
                    <input class="full-width has-padding has-border" id="signup-password" type="text" name="password" placeholder="Password" required>
                    <a href="#0" class="hide-password">Hide</a>
                    <span class="cd-error-message">Passwords may be different</span>
                </p>

                <p class="fieldset">
                    <label class="image-replace cd-password" for="signup-password">Password</label>
                    <input class="full-width has-padding has-border" id="signup-password" type="text" name="confirm_password" placeholder="Confirm password" required>
                    <a href="#0" class="hide-password">Hide</a>
                    <span class="cd-error-message">Passwords may be different</span>
                </p>

                <p class="fieldset">
                    <input type="checkbox" id="accept-terms" required>
                    <label for="accept-terms" style="color: black">I agree to the <a href="#0">Terms</a></label>
                </p>

                <p class="fieldset">
                    <input class="full-width has-padding" type="submit" value="Create account">
                </p>
            </form>

            <!-- <a href="#0" class="cd-close-form">Close</a> -->
        </div> <!-- cd-signup -->

        <div id="cd-reset-password"> <!-- reset password form -->
            <p class="cd-form-message">Lost your password? Please enter your email address. You will receive a link to create a new password.</p>

            <form class="cd-form">
                <p class="fieldset">
                    <label class="image-replace cd-email" for="reset-email">E-mail</label>
                    <input class="full-width has-padding has-border" id="reset-email" type="email" placeholder="E-mail">
                    <span class="cd-error-message">Error message here!</span>
                </p>

                <p class="fieldset">
                    <input class="full-width has-padding" type="submit" value="Reset password">
                </p>
            </form>

            <p class="cd-form-bottom-message"><a href="#0">Back to log-in</a></p>
        </div> <!-- cd-reset-password -->
        <a href="#0" class="cd-close-form">Close</a>
    </div> <!-- cd-user-modal-container -->
</div> <!-- cd-user-modal -->


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="Vues/modal/js/main.js"></script> <!-- Gem jQuery -->


<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script type="text/javascript" src="Vues/js.js"></script>
</body>

</html>
