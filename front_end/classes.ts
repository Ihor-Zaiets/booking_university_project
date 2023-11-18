class Point {
    x: number;
    y: number;

    readonly description: string;

    constructor(x: number, y:number, description:string) {
        this.x = x;
        this.y = y;
        this.description = description;
    }
}

let newPoint = new Point(1, 1, "first point");
newPoint.x = 5;