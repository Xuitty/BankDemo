import Decimal from 'decimal.js';
import { Account } from './account';
import { Card } from './card';

export class Info {
  uid!: number;
  uname!: string;
  allAccount!: Account[];
  allActivedAccount!: Account[];
  allCreditCard!: Card[];
  allActivedCreditCard!: Card[];
  allDebitCard!: Card[];
  allActivedDebitCard!: Card[];
  totalMoney!: string;
  lasttime: number = -1;
}
