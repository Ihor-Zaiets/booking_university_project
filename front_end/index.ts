//defining variables

let myNumber: number = 100;
let myString: string = 'string';
let myBoolean: boolean = true;
let myArray: any = [1, 'two', false]

let variables: any = [
    myNumber,
    myString,
    myBoolean,
    myArray
];

//defining functions

function writeToConsole(parameter) {
    console.log('Parameter passed to function:', parameter);
}

function sum(a: number, b: number) {
    return a + b;
}

// object type with optional properties
function printPoint(point: {x?: number, y?: number}) {
    console.log('Printing point:')
    console.log('x = ', point.x?.toString());
    console.log('y = ', point.y?.toString());
}

function printTypePoint(point: typePoint) {
    console.log('Printing type point')
    printPoint({x: point.typeX, y: point.typeY})
}
// type alies

type typePoint = {
    typeX: number;
    typeY: number
}
// union type
function printUnionValue(value: string | number) {
    console.log('Printing union value:')
    if (typeof value === "string") {
        console.log(value.toUpperCase())
    } else {
        console.log(value + 100);
    }
}

console.log('my variables:',variables);
console.log('my variables through for each loop:');
variables.forEach((myVar) => {
    console.log(myVar);
})
writeToConsole('Hi');
writeToConsole(sum(5,6));
printPoint({x: 1});
printPoint({y: 1});
printPoint({x: 1, y: 1});
printPoint({});
printUnionValue("sto");
printUnionValue(100);
let myTypePointVariable: typePoint = {typeX: 10, typeY: 15};
printPoint({x: myTypePointVariable.typeX, y: myTypePointVariable.typeY});
printTypePoint(myTypePointVariable)