var exec = require('cordova/exec');

exports.coolMethod = function (message, success, error) {
    exec(success, error, 'AppICEPlugin', 'coolMethod', [message]);
};
