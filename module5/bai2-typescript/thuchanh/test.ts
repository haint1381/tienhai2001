let num1:number = 1;

function letDeclaration() {
    let num2:number = 2;

    if (num2 > num1) {
        var num3: number = 3;
        num3++;
    }

    while(num1 < num2) {
        var num4: number = 4;
        num1++;
    }

    console.log(num1); //OK
    console.log(num2); //OK
    console.log(num3); //Compiler Error: Cannot find name 'num3'
    console.log(num4); //Compiler Error: Cannot find name 'num4'
}

letDeclaration();

let abc= new Promise(
    function (resolve, reject) {

    }
);
