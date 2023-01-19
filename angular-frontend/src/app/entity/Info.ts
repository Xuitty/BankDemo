import Decimal from "decimal.js";

export class Info {
    uid!: number;
    uname!:string;
    account!:number;
    creditCard!:number;
    debitCard!:number;
    totalMoney!:Decimal;
  }