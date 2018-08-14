
const Utils = {};//function () {}

Utils.sun = function (x) {
    function add(y) {
        x = x + y;
        return add;
    }
    add.toString = add.valueOf = function () {
        return +x;
    }
    return add;
}

Utils.isValueType = function (value) {
    return ({}).toString.call(value);
}

// const utils = (new Utils);
export default Utils;