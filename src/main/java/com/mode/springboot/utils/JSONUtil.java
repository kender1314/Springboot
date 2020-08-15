package com.mode.springboot.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * Json工具�?
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
@Slf4j
public class JSONUtil {

    public static void main(String[] args) {
        try {
            String s1 = "{\"data\":{\"name\":\"jiang\",\"data_histogram\":{\"interval\":\"2w\"},\"arr\":[1,2,3]}}";
            String s3 = "[1,2,3]";
            JSONObject json = JSONUtil.toJo(s1);
            JSONUtil.replaceKey(json, "data_histogram.interval", "data_histogram.cccc");
//            JSONArray arr = JSONUtil.toJa(s3);
//            JSONObject js = JSONUtil.removeJSONValue(json, "data.name");
            System.out.println(json);
        } catch (Exception e) {
            System.out.println("出错�?");
        }
    }

    /**
     * 根据带有�?.”的keys获取对应的�??
     *
     * @param jo        {@link JSONObject}
     * @param keys      带有�?.”的keys(e.g：hits._source.name)
     * @param elseValue 如果没有根据找到相应的�?�，则返回这个�??
     * @return 根据eys获取对应的�?�，否则返回elseValue
     */
    public static <T> T getJSONValue(JSONObject jo, String keys, T elseValue) {
        Object value = getJSONValue(jo, keys);
        if (value == null) {
            return elseValue;
        } else {
            try {
                return (T) value;
            } catch (Exception e) {
                log.error("Cast" + value.getClass().getSimpleName() + "to" + elseValue.getClass().getSimpleName() + "failed", e);
                return elseValue;
            }
        }
    }

    /**
     * 根据带有�?.”的keys获取对应的�??
     *
     * @param jo   {@link JSONObject}
     * @param keys 有�??.”的keys(e.g：hits._source.name)
     * @return 根据eys获取对应的�??
     */
    public static Object getJSONValue(JSONObject jo, String keys) {
        Object res;
        String[] splits;
        try {
            while (!CollectionUtils.isEmpty(jo) && keys != null) {
                splits = keys.split("\\.");
                String split = splits[0];
                res = jo.get(split.indexOf("[") > 0 ? split.substring(0, split.lastIndexOf("[")) : split);

                if (splits.length == 1) {
                    int indexNum = getIndexNum(split);
                    if (indexNum >= 0) {
                        res = getInner(res, indexNum);
                    }
                    return res;
                }
                keys = keys.substring(keys.indexOf(".") + 1);
                res = getInner(res, 0);
                jo = toJo(res);
            }
        } catch (Exception ignored) {

        }
        return null;
    }

    private static int getIndexNum(String str) {
        int firstChar = str.lastIndexOf("[");
        int lastChar = str.lastIndexOf("]");
        if (firstChar == -1 || lastChar == -1 || firstChar > lastChar) {
            return -1;
        }
        String index = str.substring(firstChar + 1, lastChar);
        try {
            return Integer.parseInt(index);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static Object getInner(Object res, int index) {
        JSONArray arr;
        while ((arr = toJa(res)) != null) {
            res = arr.isEmpty() ? null : (arr.size() > index ? arr.get(index) : arr.get(0));
        }
        return res;
    }

    /**
     * 将对象转换为JSONArray
     *
     * @param obj Object
     * @return {@link JSONArray}
     */
    public static JSONArray toJa(Object obj) {
        try {
            if (obj instanceof String) {
                return JSON.parseArray((String) obj);
            }
            if (obj instanceof JSONArray) {
                return (JSONArray) obj;
            }
            return (JSONArray) JSON.toJSON(obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将对象转换为JSONObject
     *
     * @param obj Object
     * @return {@link JSONObject}
     */
    public static JSONObject toJo(Object obj) {
        try {
            if (obj instanceof String) {
                return JSON.parseObject((String) obj);
            }
            if (obj instanceof JSONObject) {
                return (JSONObject) obj;
            }
            return (JSONObject) JSON.toJSON(obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据带有�?.”的keys为JSONObject设置�?
     *
     * @param jo    {@link JSONObject}
     * @param keys  带有�?.”的keys(e.g：hits._source.name)
     * @param value 要设置的�?
     * @return new {@link JSONObject}
     */
    public static JSONObject setJSONValue(JSONObject jo, String keys, Object value) {
        if (keys == null) {
            return jo;
        }
        if (jo == null) {
            jo = new JSONObject();
        }
        String[] fields = keys.split("\\.");
        String field = fields[fields.length - 1];
        if (fields.length == 1) {
            jo.put(field, value);
        } else {
            String root = keys.substring(0, keys.indexOf("."));
            JSONObject newJson = jo.getJSONObject(root);
            if (newJson == null) {
                newJson = new JSONObject();
            }
            keys = keys.substring(keys.indexOf(".") + 1);
            jo.put(root, setJSONValue(newJson, keys, value));
        }
        return jo;
    }

    /**
     * 根据带有�?.”的keys删除JSONObject中的�?
     *
     * @param jo   {@link JSONObject}
     * @param keys 带有�?.”的keys(e.g：hits._source.name)
     * @return new {@link JSONObject}
     */
    public static JSONObject removeJSONValue(JSONObject jo, String keys) {
        if (keys != null && jo != null) {
            String[] fields = keys.split("\\.");
            String field = fields[fields.length - 1];
            if (fields.length == 1) {
                jo.remove(field);
            } else {
                String root = keys.substring(0, keys.indexOf("."));
                JSONObject newJson = jo.getJSONObject(root);
                if (newJson == null) {
                    newJson = new JSONObject();
                }
                keys = keys.substring(keys.indexOf(".") + 1);
                jo.remove(removeJSONValue(newJson, keys));
            }
            return jo;
        }
        return new JSONObject();
    }

    /**
     * 使用递归，对传入的JSONObject中的指定key进行移除，以及替换成为new key
     *
     * @param json    {@link JSONObject}
     * @param oldKeys 旧的key（key的父key+将被替换的key�?
     *                e.g：我要将json中所有data_histogram下的interval替换为fixed_interval
     *                传入的�?�格式：data_histogram.interval
     * @param newKeys 新的keys（旧的父key + 新的key�?
     *                传入值格式：data_histogram.fixed_interval
     * @return 替换后的 {@link JSONObject}
     */
    public static JSONObject replaceKey(JSONObject json, String oldKeys, String newKeys) {
        if (json == null) {
            return new JSONObject();
        }
        if (oldKeys == null || newKeys == null ||
                oldKeys.split("\\.").length != 2 || newKeys.split("\\.").length != 2) {
            log.warn("输入的oldKeys�?" + oldKeys + "或newKeys�?" + newKeys + "不符合规范！");
            return json;
        }
        String oldParentKey = oldKeys.split("\\.")[0];
        JSONObject dataHistogramValue = toJo(getJSONValue(json, oldParentKey));
        Object intervalValue = getJSONValue(json, oldKeys);
        if (dataHistogramValue != null && intervalValue != null) {
            removeJSONValue(json, oldKeys);
            setJSONValue(json, newKeys, intervalValue);
        }
        JSONObject jo = new JSONObject();
        for (Map.Entry<String, Object> next : json.entrySet()) {
            String key = next.getKey();
            Object value = next.getValue();
            JSONObject valueToJson = toJo(value);
            if (valueToJson != null) {
                jo.put(key, replaceKey(valueToJson, oldKeys, newKeys));
            } else {
                replaceJsonArr(json, key, oldKeys, newKeys);
                jo.put(key, value);
            }
        }
        return jo;
    }

    /**
     * 遍历json数组的对象，如果数组中存在interval，则替换成为calendar_interval，fixed_interval
     *
     * @param json {@link JSONObject}
     * @param key  key
     */
    private static void replaceJsonArr(JSONObject json, String key,
                                       String oldKeys, String newKeys) {
        try {
            JSONArray jsonArr = json.getJSONArray(key);
            if (jsonArr != null) {
                for (Object o : jsonArr) {
                    JSONObject objToJson = toJo(o);
                    if (objToJson != null) {
                        replaceKey(objToJson, oldKeys, newKeys);
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }

}
