function hello() {
    return "1: Hello World!";
}

const sayHello = () => {
    return "2: Hello World!";
}

const welcome = function () {
    return "3: Hello World!";
}

class Greeting {
    constructor() {
        this.message = "Hello World!";
        this.doSay = hello;
    }

    showMessage() {
        // 4:
        return this.message;
    }


}