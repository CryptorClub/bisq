/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.desktop.components.paymentmethods;

import bisq.core.payment.AccountAgeWitnessService;
import bisq.core.payment.PaymentAccount;
import bisq.core.payment.payload.PaymentAccountPayload;
import bisq.core.util.BSFormatter;
import bisq.core.util.validation.InputValidator;

import javafx.scene.layout.GridPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SameBankForm extends BankForm {
    private static final Logger log = LoggerFactory.getLogger(SameBankForm.class);

    public static int addFormForBuyer(GridPane gridPane, int gridRow, PaymentAccountPayload paymentAccountPayload) {
        return BankForm.addFormForBuyer(gridPane, gridRow, paymentAccountPayload);
    }

    public SameBankForm(PaymentAccount paymentAccount, AccountAgeWitnessService accountAgeWitnessService, InputValidator inputValidator,
                        GridPane gridPane, int gridRow, BSFormatter formatter) {
        super(paymentAccount, accountAgeWitnessService, inputValidator, gridPane, gridRow, formatter);
    }
}
