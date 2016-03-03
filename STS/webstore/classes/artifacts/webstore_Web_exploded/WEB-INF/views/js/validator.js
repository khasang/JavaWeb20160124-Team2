/**
 * Шаблон Стратегия. Выполняет проверку формы перед отправкой на сервер
 */
var validator = {
    //Все доступные проверки
    type: {},
    //Текущие сообщения
    messages: [],
    //имя: тип проверки
    config: {},
    //имя поля input: имя поля вспомогательного сообщения
    helpText: {},
    validate: function (data) {
        var i, type, msg, checker, result_ok, j,
            toString = Object.prototype.toString,
            objectType = "[object Object]",
            stringType = "[object String]",
            nullType = "[object Null]",
            arrayType = "[object Array]";
        this.messages = [];
        for (i in data) {
            if (data.hasOwnProperty(i)) {
                type = this.config[i];
                if (!type) {
                    continue;
                }
                if (toString.call(type) === objectType) {
                    for (j in type) {
                        checker = this.type[j];

                        if (!checker) {
                            throw {
                                name: "Error",
                                message: "Not handler to validate type " + j
                            }
                        }

                        if (toString.call(type[j]) === nullType) {
                            result_ok = checker.validate(data[i]);
                        } else if (toString.call(type[j]) === arrayType) {
                            type[j].unshift(data[i]);
                            result_ok = checker.validate.apply(this, type[j]);
                        } else {
                            result_ok = checker.validate.apply(this, [data[i], type[j]]);
                        }

                        if (!result_ok) {
                            msg = checker.instruction;
                            if(this.helpText[i] !== null) {
                                this.helpText[i].innerHTML = msg;
                            }
                            this.messages.push(i + " " + msg);
                            break;
                        } else {
                            if(this.helpText[i] !== null) {
                                this.helpText[i].innerHTML = "";
                            }
                        }
                    }
                } else if (toString.call(type) === stringType) {
                    checker = this.type[type];

                    if (!checker) {
                        throw {
                            name: "Error",
                            message: "Not handler to validate type " + type
                        }
                    }

                    result_ok = checker.validate(data[i]);

                    if (!result_ok) {
                        msg = checker.instruction;
                        if(this.helpText[i] !== null) {
                            this.helpText[i].innerHTML = msg;
                        }
                        this.messages.push(i + " " + msg);
                    } else {
                        if(this.helpText[i] !== null) {
                            this.helpText[i].innerHTML = "";
                        }
                    }
                }
            }
        }
        return this.hasErrors();
    },
    hasErrors: function () {
        return this.messages.length !== 0;
    }
};