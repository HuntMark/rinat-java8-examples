package com.example.stepik_java.mailservice;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MailServiceWrapper {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }

    }

    /*
    Посылка, содержимое которой можно получить с помощью метода `getContent`
    */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }

    }

    /*
    Абстрактный класс,который позволяет абстрагировать логику хранения
    источника и получателя письма в соответствующих полях класса.
    */
    public static abstract class AbstractSendable implements Sendable {
        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;

            return true;
        }
    }

    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException() {
        }

        public IllegalPackageException(String message) {
            super(message);
        }

        public IllegalPackageException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException() {
        }

        public StolenPackageException(String message) {
            super(message);
        }

        public StolenPackageException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                MailPackage mailPackage = (MailPackage) mail;
                if (mailPackage.getContent().getContent().equalsIgnoreCase(WEAPONS)
                        || mailPackage.getContent().getContent().equalsIgnoreCase(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException("Illegal package");
                }
                if (mailPackage.getContent().getContent().contains("stones")) {
                    throw new StolenPackageException("Stolen package");
                }
            }
            return mail;
        }
    }

    public static class Thief implements MailService {
        private int minValue;
        private int stolenValue;

        public Thief(int minValue) {
            this.minValue = minValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                MailPackage mailPackage = (MailPackage) mail;
                if (mailPackage.getContent().getPrice() >= this.minValue) {
                    this.stolenValue += mailPackage.getContent().getPrice();
                    return new MailPackage(
                            mail.getFrom(),
                            mail.getTo(),
                            new Package("stones instead of " + mailPackage.getContent().getContent(), 0));
                }
            }
            return mail;
        }

        public int getStolenValue() {
            return stolenValue;
        }
    }

    public static class Spy implements MailService {

        private Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                if (AUSTIN_POWERS.equalsIgnoreCase(mail.getFrom()) || AUSTIN_POWERS.equalsIgnoreCase(mail.getTo())) {
                    logger.log(Level.WARNING,
                            "Detected target mail correspondence: from "
                                    + mail.getFrom() + " to " + mail.getTo()
                                    + " \"" + ((MailMessage) mail).getMessage() + "\"");
                } else {
                    logger.log(Level.INFO, "Usual correspondence: from " + mail.getFrom() + " to " + mail.getTo());
                }
            }
            return mail;
        }
    }

    public static class UntrustworthyMailWorker implements MailService {

        private MailService[] mailServices;
        private MailService realMailService = new RealMailService();

        public UntrustworthyMailWorker(MailService[] mailServices) {
            this.mailServices = mailServices;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            Sendable processedMail = null;

            for (MailService mailService : this.mailServices) {
                if (processedMail == null) {
                    processedMail = mailService.processMail(mail);
                } else {
                    processedMail = mailService.processMail(processedMail);
                }
            }

            return getRealMailService().processMail(processedMail);
        }

        public MailService getRealMailService() {
            return this.realMailService;
        }
    }
}
