# Financial Calculators App

Contains 3 calculators:
- Mortgage Payments
- Future Value
- Annuity Value

## Examples

### Homepage
```
Choose a calculator to run:
  1: Mortgage Payments
  2: Future Value
  3: Annuity Value
or type "help" for more help.
```

### Mortgage Payments
```
Loan amount (dollars): 2000
Interest rate (percent per year): 7
Loan length (years): 10

Expected monthly payment: $23.22
Expected total payment:   $2786.60
```

### Future Value
```
Deposit value (dollars): 600
Interest rate (percent per year, compounded daily): 12
Length (years): 5

Total value at end of period: $1093.16
Total interest gained:        $493.16
```

### Annuity Value
```
Monthly payout (dollars): 200
Interest rate (percent per year, compounded daily): 3
Length (years): 5

The present value of this annuity is $11130.47
```

## Error Handling

Bad inputs are handled gracefully.

```
Deposit value (dollars): millions
Bad input: millions
Please try again.
Deposit value (dollars): 
```

The logic for this is in `Calculator.queryDouble()`. This is interesting because I reuse it across all of the calculators via inheritance.
