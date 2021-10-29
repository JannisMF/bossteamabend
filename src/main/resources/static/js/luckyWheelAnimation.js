let segments = "";
let numberOfSegments = 8;
let winPrice
let allPrices
let randomNumber

function setup(allPrice, thePrice, random) {
    winPrice = thePrice
    allPrices = allPrice
    randomNumber = random
    numberOfSegments = allPrices.length
    for (let i = 0; i < allPrices.length; i++) {
        let price = allPrices[i]
        let color = price["hexColor"]
        let segmentText = price["segmentText"]
        let pricePercent = (price["probability"] / 10)
        segments += "{'fillStyle': '" + color
            + "', 'text': '" + segmentText
            + "', 'size': " + winwheelPercentToDegrees(pricePercent) + "}"
        if (i != (allPrices.length - 1)) {
            segments += ", "
        }
    }


    let theWheel = new Winwheel({
        'numSegments': numberOfSegments,
        'outerRadius': 170,
        'segments':
            [
                segments
            ],
        'animation':
            {
                'type': 'spinToStop',
                'duration': 5,
                'spins': 8,
                'callbackAfter': 'drawTriangle()'
            }
    });

// Function with formula to work out stopAngle before spinning animation.
// Called from Click of the Spin button.
    function calculatePrize() {
        // This formula always makes the wheel stop somewhere inside prize 3 at least
        // 1 degree away from the start and end edges of the segment.
        let stopAt = calculateDegreeFromPT(randomNumber)

        // Important thing is to set the stopAngle of the animation before stating the spin.
        theWheel.animation.stopAngle = stopAt;

        // May as well start the spin from here.
        theWheel.startAnimation();
    }

// Usual pointer drawing code.
    drawTriangle();

    function drawTriangle() {
        // Get the canvas context the wheel uses.
        let ctx = theWheel.ctx;

        ctx.strokeStyle = 'navy';     // Set line colour.
        ctx.fillStyle = 'aqua';     // Set fill colour.
        ctx.lineWidth = 2;
        ctx.beginPath();              // Begin path.
        ctx.moveTo(170, 5);           // Move to initial position.
        ctx.lineTo(230, 5);           // Draw lines to make the shape.
        ctx.lineTo(200, 40);
        // ctx.lineTo(171, 5);
        // ctx.stroke();                 // Complete the path by stroking (draw lines).
        ctx.fill();                   // Then fill.
    }

    function calculateDegreeFromPT(pt) {
        return ((pt * 360) / 1000)
    }
}


