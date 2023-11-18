function executeFunctionWithParameter(parameter: string, fn: (s: string) => void) {
    console.log("Executing function with parameter:")
    fn(parameter)
    console.log('\n')
}

function printToConsole(text: string) {
    console.log(text);
}

executeFunctionWithParameter('my text', printToConsole);

// call signature

type FunctionWithDescription = {
    description: string,
    callableFunction: (parameter) => void
}

let myFunction: FunctionWithDescription = {
    description: "",
    callableFunction: function (parameter) {
        console.log("Executing function with description")
        console.log("Function description:", this.description)
        console.log("Function parameter:", parameter)
        console.log('\n')
    }
};

myFunction.description = "Description of my function";

//I was trying to expend functionality of that function, doesn't work
//myFunction.callableFunction = myFunction.callableFunction & (parameter) => console.log(parameter, parameter);

myFunction.callableFunction("parameter value");

function genericFunction<Type>(param: Type): Type {
    console.log("Executing generic function:")
    return param;
}

console.log(genericFunction("10").toUpperCase())
console.log('\n')
