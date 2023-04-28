package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.impl.FruitTransactionDaoIml;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private FruitTransactionDao fruitTransactionDao;

    public PurchaseOperation(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        FruitTransaction getFt = fruitTransactionDao.get(fruitTransaction.getFruit());
        int fruitQuantity = getFt.getQuantity() - fruitTransaction.getQuantity();
        getFt.setQuantity(fruitQuantity);
        fruitTransactionDao.update(getFt);
    }
}
