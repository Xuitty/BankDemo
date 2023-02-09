import Decimal from 'decimal.js';

export class Transfer {
  senderAid?: number;
  receiverBankCode?: number;
  receiverAid?: number;
  amount?: Decimal = new Decimal(-1); //do not use in front-end
  amountString?: string;
  currencyType?: number;
  schedule?: boolean;
  scheduleTime?: number;
  operateTime?: number;
  verify?: string;
}
