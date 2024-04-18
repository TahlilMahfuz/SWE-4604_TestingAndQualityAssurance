function calculateTotalSales(locks, stocks, barrels) {
    if(locks < 0 || stocks < 0 || barrels < 0){
        throw new Error('Invalid input');
    }
    if(locks > 70 || stocks > 80 || barrels > 90){
        throw new Error('Invalid input');
    }
    return (locks * 45 + stocks * 30 + barrels * 25)*0.2;
}


describe('Strong Normal', () => {
    test('TC01', () => {
      const locks = 0;
      const stocks = 0;
      const barrels = 0;
      
      const totalSalesAmount = calculateTotalSales(locks, stocks, barrels);
      
      expect(totalSalesAmount).toBe(0);
    });
    test('TC02', () => {
        const locks = 70;
        const stocks = 80;
        const barrels = 90;
        
        const totalSalesAmount = calculateTotalSales(locks, stocks, barrels);
        
        expect(totalSalesAmount).toBe(1560);
    });
    test('TC03', () => {
        const locks = 40;
        const stocks = 50;
        const barrels = 60;
        
        const totalSalesAmount = calculateTotalSales(locks, stocks, barrels);
        
        expect(totalSalesAmount).toBe(960);
    });
});

describe('Weak Robust', () => {
    test('TC01', () => {
        const locks = -1;
        const stocks = 40;
        const barrels = 50;
        
        expect(() => calculateTotalSales(locks, stocks, barrels)).toThrow('Invalid input');
    });
    test('TC02', () => {
        const locks = 40;
        const stocks = -1;
        const barrels = 50;
        
        expect(() => calculateTotalSales(locks, stocks, barrels)).toThrow('Invalid input');
    });
    test('TC03', () => {
        const locks = 40;
        const stocks = 50;
        const barrels = -1;
        
        expect(() => calculateTotalSales(locks, stocks, barrels)).toThrow('Invalid input');
    });
    test('TC04', () => {
        const locks = 71;
        const stocks = 40;
        const barrels = 50;
        
        expect(() => calculateTotalSales(locks, stocks, barrels)).toThrow('Invalid input');
    });
    test('TC05', () => {
        const locks = 40;
        const stocks = 81;
        const barrels = 50;
        
        expect(() => calculateTotalSales(locks, stocks, barrels)).toThrow('Invalid input');
    });
    test('TC06', () => {
        const locks = 40;
        const stocks = 50;
        const barrels = 91;
        
        expect(() => calculateTotalSales(locks, stocks, barrels)).toThrow('Invalid input');
    });
    test('TC07', () => {
        const locks = -1;
        const stocks = 80;
        const barrels = 91;
        
        expect(() => calculateTotalSales(locks, stocks, barrels)).toThrow('Invalid input');
    });
});
  

describe('Strong Robust', () => {
    test('TC01', () => {
        const locks = -1;
        const stocks = 40;
        const barrels = 50;
        
        expect(() => calculateTotalSales(locks, stocks, barrels)).toThrow('Invalid input');
    });
    test('TC02', () => {
        const locks = 40;
        const stocks = -1;
        const barrels = 50;
        
        expect(() => calculateTotalSales(locks, stocks, barrels)).toThrow('Invalid input');
    });
    test('TC03', () => {
        const locks = 40;
        const stocks = 50;
        const barrels = -1;
        
        expect(() => calculateTotalSales(locks, stocks, barrels)).toThrow('Invalid input');
    });
    test('TC04', () => {
        const locks = -1;
        const stocks = -1;
        const barrels = 40;
        
        expect(() => calculateTotalSales(locks, stocks, barrels)).toThrow('Invalid input');
    });
    test('TC05', () => {
        const locks = 40;
        const stocks = -1;
        const barrels = -1;
        
        expect(() => calculateTotalSales(locks, stocks, barrels)).toThrow('Invalid input');
    });
    test('TC06', () => {
        const locks = -1;
        const stocks = 50;
        const barrels = -1;
        
        expect(() => calculateTotalSales(locks, stocks, barrels)).toThrow('Invalid input');
    });
    test('TC07', () => {
        const locks = -1;
        const stocks = -1;
        const barrels = -1;
        
        expect(() => calculateTotalSales(locks, stocks, barrels)).toThrow('Invalid input');
    });
});