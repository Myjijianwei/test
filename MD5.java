public class MD5Encryption {
    public static String encrypt(String input) {
        try {
            // 创建一个 MD5 消息摘要对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 将输入字符串转换为字节数组
            byte[] inputBytes = input.getBytes();
            // 计算摘要
            byte[] hashBytes = md.digest(inputBytes);

            // 将字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // 捕获异常
            e.printStackTrace();
            return null;
        }
    }
