validator.type.isNonEmpty = {
    validate: function (value) {
        return value !== "";
    },
    instruction: " - поле обязательно для заполнения"
};

validator.type.inputLength = {
    validate: function (value, num, num2) {
        num2 = num2 || null;
        if (num2 == null) {
            this.type.inputLength.instruction = " - не может быть меньше " + num + " символов";
            return value.length >= num;
        } else {
            this.type.inputLength.instruction = " - не может быть меньше " + num + " символов и больше " + num2 + " символов";
            return (value.length >= num && value.length <= num2);
        }
    },
    instruction: ""
};

validator.type.testRegEx = {
    validate: function (value, regEx) {
        return regEx.test(value);
    },
    instruction: " - может содержать только латинские символы и цифры"
};

validator.helpText = {
    username: document.getElementById("username_help_text"),
    password: document.getElementById("password_help_text")
};

var login_form = document.getElementById("login_form"),
    username_field = document.getElementById("username"),
    password_field = document.getElementById("password"),
    data = {},
    username = "",
    password = "";

utils.addListener(username_field, "keyup", function (event) {
    username = username_field.value;

    data = {
        username: username
    };

    validator.config = {
        username: {isNonEmpty: null, inputLength: [4, 20], testRegEx: /^[a-zA-Z1-9]+$/}
    };

    validator.validate(data);
    if (validator.hasErrors()) {
        console.log(validator.messages);
    }
});

utils.addListener(password_field, "keyup", function (event) {
    password = password_field.value;

    data = {
        password: password
    };

    validator.config = {
        password: {isNonEmpty: null, inputLength: [4, 12]}
    };

    validator.validate(data);
    if (validator.hasErrors()) {
        console.log(validator.messages);
    }
});

utils.addListener(login_form, "submit", function (event) {
    username = username_field.value;
    password = password_field.value;

    data = {
        username: username,
        password: password
    };

    validator.config = {
        username: {isNonEmpty: null, inputLength: [4, 20], testRegEx: /^[a-zA-Z1-9]+$/},
        password: {isNonEmpty: null, inputLength: [4, 12]}
    };

    validator.validate(data);
    if (validator.hasErrors()) {
        if (event.preventDefault) {
            event.preventDefault();
        } else {
            event.returnValue = false;
        }
        console.log(validator.messages);
    }
});