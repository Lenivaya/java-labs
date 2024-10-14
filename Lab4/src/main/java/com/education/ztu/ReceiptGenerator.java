package com.education.ztu;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class ReceiptGenerator {

  private static final String SEPARATOR = "=".repeat(65);
  private static final String DATE_FORMAT = "dd.MM.yyyy HH:mm:ss";
  private static final String HEADER_FORMAT = "%-3s %-15s %-15s %15s%n";
  private static final String ITEM_FORMAT = "%3d. %-15s %-15s %15s%n";
  private static final String TOTAL_FORMAT = "%-36s %15s%n";
  private static final String DATE_TIME_FORMAT = "%-34s %15s%n";

  public static String generateReceipt(List<Product> products, Locale locale) {
    var bundle = ResourceBundle.getBundle("receipt", locale);
    var currencyFormatter = NumberFormat.getCurrencyInstance(locale);

    var sb = new StringBuilder();
    var formatter = new Formatter(sb);

    appendDateTime(formatter, bundle);
    appendHeader(formatter, bundle);
    double total = appendProducts(
      formatter,
      products,
      bundle,
      currencyFormatter
    );
    appendFooter(formatter, total, bundle, currencyFormatter);

    return formatter.toString();
  }

  private static void appendDateTime(
    Formatter formatter,
    ResourceBundle bundle
  ) {
    var now = LocalDateTime.now();
    var dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
    formatter.format(
      DATE_TIME_FORMAT,
      bundle.getString("date_time") + ":",
      dtf.format(now)
    );
  }

  private static void appendHeader(Formatter formatter, ResourceBundle bundle) {
    formatter.format("%s%n", SEPARATOR);
    formatter.format(
      HEADER_FORMAT,
      bundle.getString("number"),
      bundle.getString("product"),
      bundle.getString("category"),
      bundle.getString("price")
    );
    formatter.format("%s%n", SEPARATOR);
  }

  /**
   * Appends the list of products to the receipt.
   *
   * @param formatter           the Formatter to append the products to
   * @param products          the list of products to append
   * @param bundle            the ResourceBundle to use for formatting
   * @param currencyFormatter the NumberFormat to use for formatting prices
   * @return the total price of all products
   */
  private static double appendProducts(
    Formatter formatter,
    List<Product> products,
    ResourceBundle bundle,
    NumberFormat currencyFormatter
  ) {
    var counter = new AtomicInteger(1);
    return products
      .stream()
      .mapToDouble(p -> {
        formatter.format(
          ITEM_FORMAT,
          counter.getAndIncrement(),
          p.name(),
          p.category(),
          currencyFormatter.format(p.price())
        );
        return p.price();
      })
      .sum();
  }

  private static void appendFooter(
    Formatter formatter,
    double total,
    ResourceBundle bundle,
    NumberFormat currencyFormatter
  ) {
    formatter.format("%s%n", SEPARATOR);
    formatter.format(
      TOTAL_FORMAT,
      bundle.getString("total") + ":",
      currencyFormatter.format(total)
    );
  }
}
