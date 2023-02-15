import Decimal from 'decimal.js';

export class Transfer {
  tid?: number;
  senderAccount?: string;
  receiverBankCode?: number;
  receiverAccount?: string;
  amount?: Decimal = new Decimal(-1); //do not use in front-end
  amountString?: string;
  currencyType?: number;
  schedule?: boolean;
  scheduleTime?: string;
  operateTime?: string;
  verify?: string;
}
