package bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.dao.TransferDAOInterface;
import bank.entity.Transfer;
import jakarta.transaction.Transactional;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	TransferDAOInterface transferDAOInterface;

	@Override
	@Transactional
	public Transfer createTransfer(Transfer transfer) {
		return transferDAOInterface.save(transfer);
	}

	@Override
	@Transactional
	public Transfer queryTransfer(Integer tid) {
		return transferDAOInterface.findByTid(tid);
	}

	@Override
	@Transactional
	public Transfer updateTransfer(Transfer transfer) {
		return transferDAOInterface.save(transfer);
	}

	@Override
	@Transactional
	public boolean deleteTransfer(Integer tid) {
		transferDAOInterface.delete(queryTransfer(tid));
		return queryTransfer(tid).getTid() == null ? true : false;
	}

}
